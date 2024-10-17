# manipulating lists

example = "We are world champions"

def wordlist(sentence):
    """ 
    manipulates sentence to wordlist then reverses lwrodlist
    """
    # creates wordlist of a string
    delimiter = " "
    wordlist = sentence.split(delimiter)
    print("Wordlist of a sentence:", wordlist, '\n')
    
    # reverses word list
    wordlist.reverse()
    print("Reversed wordlist:", wordlist)
    