#!/usr/bin/env

from flask import Flask, request
import mdb_connector

app = Flask(__name__)

@app.route('/')
def func_root():
    return "<h1> Flask is running! </h1>"

@app.route('/login', methods=['POST'])
def func_login():
    username = request.form['username']
    password = request.form['password']
    login = mdb_connector.Credentials(username,password)
    login_data = login.check()
    return login_data                

