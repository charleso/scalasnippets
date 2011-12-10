# Snippets schema
 
# --- !Ups
 
CREATE TABLE Snippet (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    title varchar(255) NOT NULL,
    desc varchar(255) NOT NULL,
    code varchar(255) NOT NULL,
    result varchar(255) NOT NULL,
    accepted boolean NOT NULL,
    views int NOT NULL,
    typeId bigint(20) NOT NULL,
    FOREIGN KEY (typeId) REFERENCES SnippetType(id),
    PRIMARY KEY (id)
);
 
# --- !Downs
 
DROP TABLE Snippet;