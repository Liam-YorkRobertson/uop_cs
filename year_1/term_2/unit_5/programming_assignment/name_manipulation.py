# Write program to display your name and perform following operations on it: 
# Display n characters from left. (Accept n as input from the user)
# Count the number of vowels. 
# Reverse it. 


# displays my_name
my_name = "Liam-York Robertson"
print(my_name)

# displays n number of characters from left of my_name
def print_n_char():
    """prints n number of characters of my name
    """
    n = input("Insert the amount of characters you want to display from the left: ")
    n = int(n)
    for letter in my_name[0:n]:
        print(letter, end="")
    print()

# counts number of vowels in my_name
def number_of_vowels():
    """prints number of vowels in my name
    """
    vowels = "aeiouAEIOU"
    count = 0
    for letter in my_name:
        if letter in vowels:
            count = count + 1
    print("The number of vowels in my name:", count)

# reverses my_name
def reverse_name():
    """reverses my name
    """
    j = len(my_name) - 1
    while j >= 0:
        print(my_name[j], end="")
        j = j -1
    print()
