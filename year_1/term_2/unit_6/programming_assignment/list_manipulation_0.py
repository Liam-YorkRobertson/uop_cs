# manipulating lists

employees = ["Lionel Messi", "John Bushman", "Kiki Chanel", "Dexter Martin", "James Manson",
    "Corey Taylor", "Elizabeth Joy", "Angela Devi", "Tumi Buthletho", "William Shake"
]

salaryList = [
    100000, 80000, 95000, 70000,  120000, 110000, 90000, 85000, 78000, 150000
]

def list_manipulation(emp_list, sal_list):
    """
    performs maniplulations on list of employees and salaries
    """
    # splits employee list into two sublists
    subList1 = emp_list[:5]
    subList2 = emp_list[5:]
    print("subList1:", subList1, "\n")
    print("subList2:", subList2, "\n")
    
    # adds employee to subList2
    subList2.append("Kriti Brown")
    print("Added employee to subList2:", subList2, "\n")
    
    # removes employee from subList1
    subList1.pop(1)
    print("Removed employee from subList1:", subList1, "\n")
    
    # merges sublists
    new_employees = subList1 + subList2
    print("Merged list:", new_employees, "\n")
    
    # give 4% rise to salaries
    new_sal =[]
    for sal in sal_list:
        new_sal.append(sal * 1.04)
    print("New salaries:", new_sal, "\n")
    
    # sort salaryList
    new_sal.sort()
    print("New salaries sorted from low to high:", new_sal, "\n")
     # show top 3 salaries
    top_3 = new_sal[-3:]
    print("The top 3 salaries are:", top_3)