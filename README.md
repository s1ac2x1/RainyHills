# Rainy Hills 1.0

The application is ready for Application Servers with EJB container support.

The architecture is DDD (thought for current simple application TransactionScript would be sufficient).
Business logic implemented as stateless EJB bean. Connecting with outside world is possible through servlet, which accepts the input string (numbers separated by comma).
I've chosen a HTML and jQuery - they are the best solutions for such a trivial task and there is no necessity to start heavy JSF environment.
Value objects and DTO mapping aren't necessary also.
The EJB is Local assuming it is suitable only for usage inside WAR and not across the whole deployment space.
To eliminate possible CPU consumption I've added in-memory caching (without eviction).

Packaging as WAR and ready for deployment to application server.
After deploy please welcome: http://localhost:8080/rainyhills-1.0/

