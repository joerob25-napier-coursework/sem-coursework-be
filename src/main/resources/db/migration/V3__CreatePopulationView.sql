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