def solution(keymap, targets):
    answer = []
    keytable = {}
    
    for keys in keymap:
        for i,key in enumerate(keys):
            if key not in keytable:
                keytable[key] = i+1
            else:
                keytable[key] = min(keytable[key],i+1)
    
    for target in targets:
        click = 0
        for key in target:
            if key not in keytable:
                click = -1
                break
            click += keytable[key]
        answer.append(click)
    
    return answer
