using System.Collections.Generic;
using System.Threading.Tasks;
using mysql.Interfaces;

namespace mysql.Services
{
    public class MeleeHitService : IMeleeHitService
    {
        AppDb _db;

        public MeleeHitService(AppDb db)
        {
            _db = db;
        }

        public async Task<List<MeleeHit>> GetAll()
        {
            await _db.Connection.OpenAsync();

            using var cmd = _db.Connection.CreateCommand();
            cmd.CommandText = "SELECT roll, event FROM MeleeHit";
            var reader = await cmd.ExecuteReaderAsync();
            var meleeHits = new List<MeleeHit>();

            using (reader)
            {
                while (await reader.ReadAsync())
                {
                    var meleeHit = new MeleeHit();
                    meleeHit.Roll = reader.GetInt32("roll");
                    meleeHit.Event = reader.GetString("event");

                    meleeHits.Add(meleeHit);
                }
            }

            await _db.Connection.CloseAsync();
            return meleeHits;
        }

        public async Task<MeleeHit> GetById(int roll)
        {
            await _db.Connection.OpenAsync();

            using var cmd = _db.Connection.CreateCommand();
            cmd.CommandText = "call getRollMeleeHit(" + roll + ")";
            var reader = await cmd.ExecuteReaderAsync();
            var meleeHit = new MeleeHit();

            using (reader)
            {
                await reader.ReadAsync();
                meleeHit.Roll = reader.GetInt32("roll");
                meleeHit.Event = reader.GetString("event");
            }

            return meleeHit;
        }

        public async Task<bool> DeleteById(int roll)
        {
            await _db.Connection.OpenAsync();

            using var cmd = _db.Connection.CreateCommand();
            cmd.CommandText = "DELETE FROM MeleeHit WHERE roll=" + roll;
            var reader = await cmd.ExecuteNonQueryAsync();

            return true;
        }

        public async Task<bool> Create(MeleeHit meleeHit)
        {
            await _db.Connection.OpenAsync();

            using var cmd = _db.Connection.CreateCommand();
            cmd.CommandText = $"INSERT INTO MeleeHit VALUES ({meleeHit.Roll}, '{meleeHit.Event}')";
            var reader = await cmd.ExecuteNonQueryAsync();

            return true;
        }
    }
}