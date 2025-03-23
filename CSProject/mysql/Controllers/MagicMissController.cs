using System.Collections.Generic;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using mysql.Interfaces;
using mysql.Models;

namespace mysql.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class MagicMissController : ControllerBase
    {
        IMagicMissService _magicMissService;

        public MagicMissController(IMagicMissService magicMissService)
        {
            _magicMissService = magicMissService;
        }

        [HttpGet]
        public async Task<IActionResult> GetProducts()
        {
            var result = await _magicMissService.GetAll();
            return Ok(result);
        }

        [HttpGet("{id}")]
        public async Task<IActionResult> GetById(int id)
        {
            var result = await _magicMissService.GetById(id);
            return Ok(result);
        }
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteById(int id)
        {
            var result = await _magicMissService.DeleteById(id);
            return Ok(result);
        }

        [HttpPost]
        public async Task<IActionResult> Create([FromBody] MagicMiss magicMiss)
        {
            var result = await _magicMissService.Create(magicMiss);
            return Ok(result);
        }

    }
}