#!/usr/bin/env python3

""" Login validation for MongoDB Databases. 

    Error Code Definition:

    0x0db1 == User Not Found
    0x0db2 == Exception

"""

from json import dumps
from pymongo import MongoClient

class Credentials:
    """ Methods for login validation. """

    connect = None
    db_user = "mongo"
    db_pass = "mongo"
    username = None
    password = None

    def __init__(self,username,password):
        self.username = username
        self.password = password

    def client(self):
        """ Preparing MongoDB client. """
        connect = MongoClient('127.0.0.1',username=self.db_user,password=self.db_pass)

    def login(self):
        """ Validating user credentials."""
        try:
            self.client()
            database = connect.android
            collection = database.Authentication
            data = collection.find_one( {"Username":self.username,"Password":self.password} )
            if data:
                data.pop("_id")
                data.pop("Password")
                return dumps(data)
            else:
                return "0x0db1"
        except Exception:
            return "0x0db2"

