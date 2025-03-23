using System;
using MySqlConnector;

namespace mysql
{
    public class AppDb : IDisposable
    {
        public MySqlConnection Connection { get; }
        public AppDb(string connection)
        {
            Connection = new MySqlConnection(connection);
        }

        public void Dispose()
        {
            ;
        }
    }
}