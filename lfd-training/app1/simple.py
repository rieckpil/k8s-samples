#!/usr/bin/python
import time
import socket

while True :
  host = socket.gethostname()
  date = time.strftime("%Y-%m-%d %H:%M:%S")
  now = str(date)
  f = open("date.out", "a")
  f.write(now + " \n")
  f.write(host + " \n")
  f.close()
  
  time.sleep(5)
## Adding a comment to create new image
