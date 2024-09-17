# creating simple pyhton functions that take arguments

# The circumference of a circle is calculated by 2πr, where π = 3.14159 (rounded to five decimal places). Write a function called print_circum that takes an argument for the circle’s radius and prints the circle's circumference.
def print_circum(radius):
    pi = 3.14159
    circum = 2 * pi * radius
    print(circum)
    
print_circum(3)
print_circum(14)
print_circum(2.5)

# Welcome to your first project.  Develop a catalog for a company. Assume that this company sells three different Items. The seller can sell individual items or a combination of any two items. A gift pack is a special combination that contains all three items.
def catalogue():
    # item values 
    item1 = float(200)
    item2 = float(400)
    item3 = float(600)
    # combination totals with discount
    combo1 = (item1 + item2) * (90/100)
    combo2 = (item2 + item3) * (90/100)
    combo3 = (item1 + item3) * (90/100)
    combo4 = (item1 + item2 + item3) * (75/100)
    # display catalogue
    print("Online Store")
    print("-----------------------")
    print("Product(S)                    Price")
    print("Item 1                       ", end=" ")
    print(item1)
    print("Item 2                       ", end=" ")
    print(item2)
    print("Item 3                       ", end=" ")
    print(item3)
    print("Combo 1(Item 1 + 2)          ", end=" ")
    print(combo1)
    print("Combo 2(Item 2 + 3)          ", end=" ")
    print(combo2)
    print("Combo 3(Item 1 + 3)          ", end=" ")
    print(combo3)
    print("Combo 4(Item 1 + 2 + 3)      ", end=" ")
    print(combo4)
    print("________________________")
    print("For delivery Contact:0123456789")

catalogue()