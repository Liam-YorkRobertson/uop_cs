# working with files in python

def catching_error():
    """
    try statement that catches with the FileNotFoundError error
    """
    try:
        open('secret_to_immortality.txt')
    except FileNotFoundError:
        print("secret_to_immortality.txt does not exist 0.0")
