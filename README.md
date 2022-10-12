# hello-java-tdd

Based on my interpretation of Robert C. Martin's Clean Craftsmanship (2021),
this is a simple end-to-end application which took a very disciplines use of
TDD, Clean Archictecture and simple design from the beginning, ending up
with near-100% test cover.

Through the console, user can (memory) store basically-encrypted messages (based
on a given key) that can be retrieved and decrypted later.

> add \<your_message\> \<encryption_key\><br>
> \# returns a index under which message was stored<br>

> get \<index\> \<decryption_key\><br>
> \# returns the message under \<index\> if the key was the one used to encrypt.

TDD approach:
- No software behavior was added without first writing the test for it.
- After passing the new test, resulting software was refactored to remain simple
  (Based on SOLID, Clean Architecture, Simplicity as per Rick Hickey (I) and
   my own experience).
- Used test doubles (spies, mocks, fakes) to test each clean archicture element
  in isolation (II).

(I) Rich Hickey, author of Clojure, on Simple Made Easy
    https://www.youtube.com/watch?v=SxdOUGdseq4

(II) test interactors in isolation from controller and gateways, test controller in
     isolation from interactors, test gateways in isolation from the storage
     implementation accessing the physical world, etc.
     Chicago school-ish, as per my interpretation of Uncle Bob's teachings.

My reviews (in portuguese):
- Robert Martin's Clean Cratfsmanship: https://lnkd.in/dNhd4bgJ
- Rich Hickey's Simple Made Easy: https://lnkd.in/dBBMKEgU
