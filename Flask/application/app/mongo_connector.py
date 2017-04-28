#!/usr/bin/env

import json
from pymongo import MongoClient

try:
    client = MongoClient('127.0.0.1',27017)
    print "Connection: OK"
    database = client.android
    print "Database: OK"
    collection = database.users
    print "Collection: OK"
except:
    print "Something went wrong..."

doc = {"Name":"Ivan Leon"}
collection.insert_one(doc)
cursor = collection.find_one()
print "%s" % cursor
