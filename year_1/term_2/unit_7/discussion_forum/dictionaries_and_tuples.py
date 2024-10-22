# exploring dictionaries and tuples


username = ["Sydney White", "Simphiwe Logo", "Micah Vladimir"]
account_id = (82057629, 20567372, 26750119)
# zip function to interleave username and account_ids then store in list
def zip_user_details():
    """
    combines username and account_id 
    """
    user_details = zip(username, account_id)
    for user in user_details:
        print(user)

def enumerate_users():
    """
    enumerates through username list
    """
    for pair in enumerate(username):
       print(pair)
    print("We currently have:", len(username), "users")
    if len(username) < 100:
        print("We need more users :(")
    else:
        print("We reached our goal :)" )

def display_user_details():
    """
    Shows account_id and username pairs using items method  
    """
    user_det_dict = dict()
    for id, user in zip(account_id, username):
        user_det_dict[id] = user
    user_items = user_det_dict.items()
    print(user_items)
    for key, value in user_items:
        print("account id:", key, " - ", "username:" , value)
