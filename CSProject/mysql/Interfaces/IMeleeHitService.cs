using System.Collections.Generic;
using System.Threading.Tasks;

namespace mysql.Interfaces
{
    public interface IMeleeHitService
    {
        Task<List<MeleeHit>> GetAll();
        Task<MeleeHit> GetById(int id);
        Task<bool> DeleteById(int id);
        Task<bool> Create(MeleeHit meleeHit);
    }
}