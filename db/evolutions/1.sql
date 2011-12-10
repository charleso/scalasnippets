# SnippetType schema
 
# --- !Ups
 
CREATE TABLE SnippetType (
    id bigint(20) NOT NULL AUTO_INCREMENT,
    title varchar(255) NOT NULL,
    desc varchar(255) NOT NULL,
    PRIMARY KEY (id)
);
 
# --- !Downs
 
DROP TABLE SnippetType;