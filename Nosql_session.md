NOSQL
-----

 - Humongous data (Big data)
 
 RDBMS
 - perfomance intensive queries in RDBMS
 - Scaling (Scale up)
    - Vertical scaling
    - add more resources to the server like cpus, ram, hard disk 
        -- there is limit
        -- adding resources is more expensive
 - Fixed schema       
 - Availibility
 
 
 Types of Data
 -------------
 transactional
 streams of data - time series
 Interconnected Data
 - 
 
 
 Product
    - details
    - inventory
    - reviews
        - reply
            - comment
 
 Profile
 -------
    skills
    certifications
    ....
 
 
 
 NoSQL - Not only SQL
 --------------------
 - Huge amount of Data
 - Scale out
    - Horizontal scaling
        - add more servers to the existing servers and form a cluster
 - Flexible schema
 - Availibility
 - replication
 
 Types of NoSQl Databases
    - Document Database
        - Document - similar to a JSON
        - MongoDB, CouchDB, AWS DocumentDB, Azure CosmosDB...
    - key-value oriented
        - values can be string, json, array, more complex datatypes
        - In Memory
          - Leaderboard
          - Session 
          - Top trending product
          ex: Redis, MemCached
    - Graph Databases
        - interconnected data
        - recommendation engine
        - Neo4j
    
    - Column Family Databases       
        - time series data
        - continuos stream of data
        - Cassandra, Hbase
 
 
 In My Application, Which database should use
 ---------------------------------------------
 
 Modern application has POLYGLOT persistence
    - uses different types of DB for different use cases
    
    
    
 MongoDB - 
 --------
 https://docs.mongodb.com/
 https://docs.mongodb.com/manual/introduction/
 https://docs.mongodb.com/manual/crud/


    - Humongous amount of data storage and processing
    - Data is stored as document
    - Each document can have flexible schema
    - very similar to JSON
    - BSON - Binay serialization form of JSON
    - store terabytes of data and still give milisec response time
    - Cluster of Servers which replicate data
    
    
    Database, Collection (Table), document (row) , records with key and value pair(Column)
    
    
    
    High Performance
        embedded data models reduces I/O 
        Rich Query Language
   High Availability
   Horizontal Scalability
    
    
    
   Connecting to MongoDB:
   
   mongo --host=localhost --port=27017

   show dbs         - list databases
   
   use db_name      - Switch to DB and create if it does not exist
      
   show collections - List collections
   
   
   db.createCollectio();
   
   
   Insert Document in collection
   -----------------------------
   
    db.Product.insertOne({'name':'computer'})

    db.products.insertOne({'name': 'laptop','category':'electronics', 'price': 50000 })
    
    
    db.products.insertMany([
        {'name': 'mouse','category':'electronics', 'price': 500 },
        {'name': 'keyboard','category':'electronics', 'price': 700 },
        {'name': 'tshirt','category':'clothing', 'price': 1500, 'tag': ['men', 'women'] },
        {'name': 'jeans','category':'clothing', 'price': 2500, 'color': 'black' }
    
    ])
    
    db.products.find({'category': 'clothing'}).pretty()
    
    db.products.find({'category': 'clothing', 'price':{$gt: 2000} }).pretty()
    
    db.products.find({$or: [{'category': 'clothing'},{'price':{$gt: 2000}}]}).pretty()


    db.products.find({'category': 'clothing'}, {name: 1, price: 1, _id: 0}).pretty()























    
    
 
 
 
