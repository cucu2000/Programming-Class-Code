using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using mysql.Interfaces;

namespace mysql.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class MeleeMissController : ControllerBase
    {
        private IMeleeMissService _meleeMissService;

        public MeleeMissController(IMeleeMissService meleeMissService)
        {
            _meleeMissService = meleeMissService;
        }
        
        [HttpGet]
        public async Task<IActionResult> GetProducts()
        {
            var result = await _meleeMissService.GetAll();
            return Ok(result);
        }

        [HttpGet("{id}")]
        public async Task<IActionResult> GetById(int id)
        {
            var result = await _meleeMissService.GetById(id);
            return Ok(result);
        }
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteById(int id)
        {
            var result = await _meleeMissService.DeleteById(id);
            return Ok(result);
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] MeleeMiss meleeMiss)
        {
            var result = await _meleeMissService.Create(meleeMiss);
            return Ok(result);
        }
    }
}