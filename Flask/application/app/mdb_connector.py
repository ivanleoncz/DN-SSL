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

        data = collection.find_one( {"User":self.user,"Password":self.password} )
        if data is None:
            return "not_found"
        else:
            data.pop("_id")
            data.pop("Password")
            return dumps(data)

