// Switch to the "admin" database to authenticate as root
db = db.getSiblingDB("admin");

// Check if the user already exists
if (db.getSiblingDB("cartdb").getUser("cartuser") === null) {
    db.createUser({
        user: "cartuser",
        pwd: "cartpassword",
        roles: [
            {
                role: "readWrite",
                db: "cartdb"
            }
        ]
    });
}

// Switch to the target database and create the collection
db = db.getSiblingDB("cartdb");
if (!db.getCollectionNames().includes("cart")) {
    db.createCollection("cart");
}