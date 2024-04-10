create table if not exists content
(
    id            bigint auto_increment primary key,
    title         varchar(255) not null,
    description   varchar(255),
    status        varchar(20)  not null,
    content_type  varchar(50)  not null,
    created_date  timestamp    not null,
    modified_date timestamp,
    url           varchar(255)
);

# insert into content(title, description, status, content_type, created_date, modified_date, url)
# values ('My Spring security blog post', 'A Post about spring security', 'IDEA', 'ARTICLE', now(), null, null);