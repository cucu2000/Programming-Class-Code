using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using mysql.Interfaces;
using mysql.Models;

namespace mysql.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class MeleeHitController : ControllerBase
    {
        private IMeleeHitService _meleeHitService;

        public MeleeHitController(IMeleeHitService meleeHitService)
        {
            _meleeHitService = meleeHitService;
        }
        
        [HttpGet]
        public async Task<IActionResult> GetProducts()
        {
            var result = await _meleeHitService.GetAll();
            return Ok(result);
        }

        [HttpGet("{id}")]
        public async Task<IActionResult> GetById(int id)
        {
            var result = await _meleeHitService.GetById(id);
            return Ok(result);
        }
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteById(int id)
        {
            var result = await _meleeHitService.DeleteById(id);
            return Ok(result);
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] MeleeHit meleeHit)
        {
            var result = await _meleeHitService.Create(meleeHit);
            return Ok(result);
        }
    }
}