#!/usr/bin/env

from flask import Flask

app = Flask(__name__)

@app.route('/')
def func_root():
    return "<h1> Flask is running! </h1>"
