## About Migration with Flyway
- Migration executed cannot be changed.
- Remove migration failed: 
```sql
delete from flyway_schema_history where success = 0;
```
