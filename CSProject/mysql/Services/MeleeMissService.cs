using System.Collections.Generic;
using System.Threading.Tasks;
using mysql.Interfaces;

namespace mysql.Services
{
    public class MeleeMissService : IMeleeMissService
    {
        private AppDb _db;

        public MeleeMissService(AppDb db)
        {
            _db = db;
        }
        public async Task<List<MeleeMiss>> GetAll()
        {
            await _db.Connection.OpenAsync();

            using var cmd = _db.Connection.CreateCommand();
            cmd.CommandText = "SELECT roll, event FROM MeleeMiss";
            var reader = await cmd.ExecuteReaderAsync();
            var meleeMisses = new List<MeleeMiss>();

            using (reader)
            {
                while (await reader.ReadAsync())
                {
                    var meleeMiss = new MeleeMiss();
                    meleeMiss.Roll = reader.GetInt32("roll");
                    meleeMiss.Event = reader.GetString("event");

                    meleeMisses.Add(meleeMiss);
                }
            }

            await _db.Connection.CloseAsync();
            return meleeMisses;
        }

        public async Task<MeleeMiss> GetById(int roll)
        {
            await _db.Connection.OpenAsync();

            using var cmd = _db.Connection.CreateCommand();
            cmd.CommandText = "call getRollMeleeMiss(" + roll + ")";
            var reader = await cmd.ExecuteReaderAsync();
            var meleeMiss = new MeleeMiss();

            using (reader)
            {
                await reader.ReadAsync();
                meleeMiss.Roll = reader.GetInt32("roll");
                meleeMiss.Event = reader.GetString("event");
            }

            return meleeMiss;
        }

        public async Task<bool> DeleteById(int roll)
        {
            await _db.Connection.OpenAsync();

            using var cmd = _db.Connection.CreateCommand();
            cmd.CommandText = "DELETE FROM MeleeMiss WHERE roll=" + roll;
            var reader = await cmd.ExecuteNonQueryAsync();
            

            return true;
        }

        public async Task<bool> Create(MeleeMiss meleeMiss)
        {
            await _db.Connection.OpenAsync();

            using var cmd = _db.Connection.CreateCommand();
            cmd.CommandText = $"INSERT INTO MeleeMiss VALUES ({meleeMiss.Roll}, '{meleeMiss.Event}')";
            var reader = await cmd.ExecuteNonQueryAsync();

            return true;
        }
    }
}