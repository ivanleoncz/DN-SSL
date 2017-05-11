#!/usr/bin/env

from app import app

app.config.from_object('config')

if __name__ == "__main__":
    app.run(host="0.0.0.0")
