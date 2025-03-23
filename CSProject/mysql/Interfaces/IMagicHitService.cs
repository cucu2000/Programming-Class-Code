using System.Collections.Generic;
using System.Threading.Tasks;

public interface IMagicHitService
{
    Task<List<MagicHit>> GetAll();
    Task<MagicHit> GetById(int id);
    Task<bool> DeleteById(int id);
    Task<bool> Create(MagicHit magicHit);
}