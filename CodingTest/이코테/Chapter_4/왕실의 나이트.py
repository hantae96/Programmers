start = "c2"

aplha_table = {"a":0,"b":1,"c":2,"d":3,"e":4,"f":5,"g":6,"h":7}

start_x = aplha_table.get(start[0])
start_y = int(start[1]) - 1

move_table = [(1,2),(1,-2),(-1,2),(-1,-2),(2,1),(2,-1),(-2,1),(-2,-1)]
answer = 0

for move in move_table:
    next_move_x = start_x+move[0]
    next_move_y = start_y+move[1]

    if -1<next_move_x<8 and -1<next_move_y<8:
        answer +=1
    
print(answer)