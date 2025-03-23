using System.Collections.Generic;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;

namespace mysql.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class MagicHitController : ControllerBase
    {
        IMagicHitService _magicHitService;

        public MagicHitController(IMagicHitService magicHitService)
        {
            _magicHitService = magicHitService;
        }

        [HttpGet]
        public async Task<IActionResult> GetProducts()
        {
            var result = await _magicHitService.GetAll();
            return Ok(result);
        }

        [HttpGet("{id}")]
        public async Task<IActionResult> GetById(int id)
        {
            var result = await _magicHitService.GetById(id);
            return Ok(result);
        }
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteById(int id)
        {
            var result = await _magicHitService.DeleteById(id);
            return Ok(result);
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] MagicHit magicHit)
        {
            var result = await _magicHitService.Create(magicHit);
            return Ok(result);
        }

    }
}