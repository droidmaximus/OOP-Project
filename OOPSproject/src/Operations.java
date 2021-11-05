package OOPSproject.src;
interface Operations
{
    public String createTable(String tableName, String[] columnNames, String[] columnTypes);
    public String printTable(String tableName);
}
class Operations_implementation implements Operations
{
    @Override
    public String createTable(String tableName, String[] columnNames, String[] columnTypes) {
        String query = "CREATE TABLE " + tableName + "(";
        for (int i = 0; i < columnNames.length; i++) {
            query += columnNames[i] + " " + columnTypes[i];
            if (i != columnNames.length - 1) {
                query += ",";
            }
        }
        query += ")";
        return query;
    }
    public String printTable(String tableName) {
        String query = "SELECT * FROM " + tableName;
        return query;
    }
}

