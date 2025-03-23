using System.Collections.Generic;
using System.Threading.Tasks;
using mysql.Models;

namespace mysql.Interfaces
{
    public interface IMagicMissService
    {
        Task<List<MagicMiss>> GetAll();
        Task<MagicMiss> GetById(int id);
        Task<bool> DeleteById(int id);
        Task<bool> Create(MagicMiss magicMiss);
    }
}