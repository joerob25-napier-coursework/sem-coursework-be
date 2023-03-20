DROP VIEW IF EXISTS `v_continent_population`;
CREATE VIEW `v_continent_population`(qID, population, in_cities, not_in_cities) as (
with continents_populations as (
    select code, continent, sum(population) as continent_population
    from country
    group by code, continent
),
     cities_populations as (
         select country_code, sum(population) as city_population
         from city
         group by country_code
     )
select
    copops.continent,
    coalesce(sum(copops.continent_population),0) as total_continent_population,
    coalesce(sum(cipops.city_population),0) as total_in_city_population,
    coalesce(sum((copops.continent_population - cipops.city_population)),0) as total_not_in_city_population
from continents_populations copops
         left join cities_populations cipops on (copops.code = cipops.country_code)
group by copops.continent
);

DROP VIEW IF EXISTS `v_region_population`;
CREATE VIEW `v_region_population`(qID, population, in_cities, not_in_cities) as (
with region_populations as (
    select code, region, sum(population) as region_population
    from country
    group by code, region
),
     cities_populations as (
         select country_code, sum(population) as city_population
         from city
         group by country_code
     )
select
    regpops.region,
    coalesce(sum(regpops.region_population),0) as total_region_population,
    coalesce(sum(cipops.city_population),0) as total_in_city_population,
    coalesce(sum((regpops.region_population - cipops.city_population)),0) as total_not_in_city_population
from region_populations regpops
         left join cities_populations cipops on (regpops.code = cipops.country_code)
group by regpops.region
);