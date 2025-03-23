using System.Collections.Generic;
using System.Threading.Tasks;

namespace mysql.Interfaces
{
    public interface IMeleeMissService
    {
        Task<List<MeleeMiss>> GetAll();
        Task<MeleeMiss> GetById(int id);
        Task<bool> DeleteById(int id);
        Task<bool> Create(MeleeMiss meleeMiss);
    }
}