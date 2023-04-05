def solution(priorities, location):    

    print_list = list(zip(priorities,range(len(priorities))))
    
    idx = 1
    
    while print_list:
        now = print_list[0]
        if max(print_list,key = lambda x : x[0]) == now:
            if now[1] == location:
                return idx
            else :
                print_list.pop(0)
                idx+=1
                continue
        else:
            print_list.append(print_list.pop(0))
            
        
        
    
    