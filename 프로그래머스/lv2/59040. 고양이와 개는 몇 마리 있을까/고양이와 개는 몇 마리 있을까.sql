select animal_type, count(animal_type) as count from ANIMAL_INS
group by animal_type
ORDER BY 1;