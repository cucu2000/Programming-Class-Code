using System.Collections.Generic;
using System.Threading.Tasks;

namespace mysql.Services
{
    public class MagicHitService : IMagicHitService
    {
        AppDb _db;

        public MagicHitService(AppDb db)
        {
            _db = db;
        }

        public async Task<bool> Create(MagicHit magicHit)
        {
            await _db.Connection.OpenAsync();

            using var cmd = _db.Connection.CreateCommand();
            cmd.CommandText = $"INSERT INTO MagicHit VALUES ({magicHit.Roll}, '{magicHit.Event}')";
            var reader = await cmd.ExecuteNonQueryAsync();

            return true;

        }

        public async Task<bool> DeleteById(int roll)
        {
            await _db.Connection.OpenAsync();

            using var cmd = _db.Connection.CreateCommand();
            cmd.CommandText = "DELETE FROM MagicHit WHERE roll=" + roll;
            var reader = await cmd.ExecuteNonQueryAsync(); ;

            return true;

        }

        public async Task<List<MagicHit>> GetAll()
        {
            await _db.Connection.OpenAsync();

            using var cmd = _db.Connection.CreateCommand();
            cmd.CommandText = "SELECT roll, event FROM MagicHit";
            var reader = await cmd.ExecuteReaderAsync();
            var magicHits = new List<MagicHit>();

            using (reader)
            {
                while (await reader.ReadAsync())
                {
                    var magicHit = new MagicHit();
                    magicHit.Roll = reader.GetInt32("roll");
                    magicHit.Event = reader.GetString("event");

                    magicHits.Add(magicHit);
                }
            }
            await _db.Connection.CloseAsync();
            return magicHits;
        }

        public async Task<MagicHit> GetById(int roll)
        {
            await _db.Connection.OpenAsync();

            using var cmd = _db.Connection.CreateCommand();
            cmd.CommandText = "call getRollMagicHit(" + roll + ")";
            var reader = await cmd.ExecuteReaderAsync();
            var magicHit = new MagicHit();

            using (reader)
            {
                await reader.ReadAsync();
                magicHit.Roll = reader.GetInt32("roll");
                magicHit.Event = reader.GetString("event");
            }

            return magicHit;
        }

    }
}