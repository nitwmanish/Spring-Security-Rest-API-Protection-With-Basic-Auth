# This Spring Boot REST webservices protected by Basic Authentication using spring security

creadential: weblogic/welcome1

# Spring Boot App
This is spring boot based rest web services. It use Apache Derby embeded database

GET--->getAll--->200

http://localhost:9001/books

Response Object

[ 

   { 
   
      "isbn":"978-0321356680",
      
      "name":"Effective Java",
      
      "discription":"Addison Wesley"
      
   },
   
   { 
   
      "isbn":"978-1617292545",
      
      "name":"Spring Boot in Action",
      
      "discription":"Manning Publications"
      
   },
   { 
   
      "isbn":"978-1491900864",
      
      "name":"Java 8 Pocket Guide",
      
      "discription":"O''Reilly"
      
   },
   
   { 
   
      "isbn":"978-0321349606",
      
      "name":"Java Concurrency in Practice",
      
      "discription":"Java Concurrency in Practice','Addison Wesley"
      
   }
   
]
________________________________________________________________________________________________
GET--->getbyId--->200

http://localhost:9001/books/{isbn}

http://localhost:9001/books/978-0321356680

Response Object

{ 
      "isbn":"978-0321356680",
      
      "name":"Effective Java",
      
      "discription":"Addison Wesley"
      
}
________________________________________________________________________________________________
POST---> create new object--->201

http://localhost:8080/books/

Payload

{ 

      "isbn":"978-8120340077",
      
      "name":"Introduction to Algorithms 3rd Edition",
      
      "discription":"Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein"
      
}
________________________________________________________________________________________________
PUT--->partial update object--->202

http://localhost:9001/books/{isbn}

http://localhost:9001/books/978-8120340077

Payload

{ 

      "isbn":"978-8120340077",
      
      "name":"Introduction to Algorithms 2rd Edition",
      
      "discription":"Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein"
      
}
________________________________________________________________________________________________

PATCH--->partial update object--->202

http://localhost:9001/books/{isbn}

http://localhost:9001/books/978-8120340077

Payload

{ 

      "isbn":"978-8120340077",
      
      "name":"Introduction to Algorithms 3rd Edition",
      
      "discription":"Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein"
      
}
________________________________________________________________________________________________

DELETE--->delete object--->202

http://localhost:9001/books/{isbn}

http://localhost:9001/books/978-8120340077




