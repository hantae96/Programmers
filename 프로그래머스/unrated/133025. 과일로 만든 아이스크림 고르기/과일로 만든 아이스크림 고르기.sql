select i.flavor
from first_half f inner join icecream_info i on f.FLAVOR = i.FLAVOR
where total_order >= 3000 and INGREDIENT_TYPE = 'fruit_based'
order by total_order desc;