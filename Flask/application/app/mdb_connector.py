#!/usr/bin/env

from json import dumps
from pymongo import MongoClient

class Credentials:

    user = " "
    password = " "

    def __init__(self,user,password):
        self.user = user
        self.password = password

    def check(self):
        try:
            client = MongoClient('127.0.0.1',27017)
            database = client.android
            collection = database.users
        except:
            return "Fail to connect to MongoDB."

        data = collection.find( {"User":self.user,"Password":self.password} ).count()
        if data == 0:
            return dumps({"Login":{"User":self.user,"Status":"nok"}},indent=4)
        else:
            return dumps({"Login":{"User":self.user,"Status":"ok"}},indent=4)
