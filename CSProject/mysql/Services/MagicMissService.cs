using System.Collections.Generic;
using System.Threading.Tasks;
using mysql.Interfaces;
using mysql.Models;

namespace mysql.Services
{
    public class MagicMissService : IMagicMissService
    {
        AppDb _db;

        public MagicMissService(AppDb db)
        {
            _db = db;
        }

        public async Task<bool> Create(MagicMiss magicMiss)
        {
            await _db.Connection.OpenAsync();

            using var cmd = _db.Connection.CreateCommand();
            cmd.CommandText = $"INSERT INTO MagicMiss VALUES ({magicMiss.Roll}, '{magicMiss.Event}')";
            var reader = await cmd.ExecuteNonQueryAsync();

            return true;

        }

        public async Task<bool> DeleteById(int roll)
        {
            await _db.Connection.OpenAsync();

            using var cmd = _db.Connection.CreateCommand();
            cmd.CommandText = "DELETE FROM MagicMiss WHERE roll=" + roll;
            var reader = await cmd.ExecuteNonQueryAsync(); ;

            return true;

        }

        public async Task<List<MagicMiss>> GetAll()
        {
            await _db.Connection.OpenAsync();

            using var cmd = _db.Connection.CreateCommand();
            cmd.CommandText = "SELECT roll, event FROM MagicMiss";
            var reader = await cmd.ExecuteReaderAsync();
            var magicMisses = new List<MagicMiss>();

            using (reader)
            {
                while (await reader.ReadAsync())
                {
                    var magicMiss = new MagicMiss();
                    magicMiss.Roll = reader.GetInt32("roll");
                    magicMiss.Event = reader.GetString("event");

                    magicMisses.Add(magicMiss);
                }
            }
            await _db.Connection.CloseAsync();
            return magicMisses;
        }

        public async Task<MagicMiss> GetById(int roll)
        {
            await _db.Connection.OpenAsync();

            using var cmd = _db.Connection.CreateCommand();
            cmd.CommandText = "call getRollMagicMiss(" + roll + ")";
            var reader = await cmd.ExecuteReaderAsync();
            var magicMiss = new MagicMiss();

            using (reader)
            {
                await reader.ReadAsync();
                magicMiss.Roll = reader.GetInt32("roll");
                magicMiss.Event = reader.GetString("event");
            }

            return magicMiss;
        }

    }
}