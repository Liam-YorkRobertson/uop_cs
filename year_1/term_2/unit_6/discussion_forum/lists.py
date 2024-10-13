# exploring lists

def are_we_one():
    William = ['male', 34, 'employed']
    John = ['male', 34, 'employed']
    return(William is John)

def i_am_you():
    Emma = ['female', 23, 'employed']
    Angeline = Emma
    return(Angeline is Emma)

current_brics = ['Brazil', 'Russia', 'India', 'China', 'South Africa']

def addition_to_brics(brics):
    if 'Iran' not in brics:
        brics.append('Iran')
    return(brics)