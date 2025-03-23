using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlayerMovement : MonoBehaviour
{

    [SerializeField]
    float speed = 100f;

    private CharacterController character;
    private Vector3 inputVector;
    private Vector3 movementVector;
    private float momentumDamping = 5f;
    private float gravity = -10f;

// Start is called before the first frame update
    void Start()
    {
        character = GetComponent<CharacterController>();
    }

    // Update is called once per frame
    void Update()
    {
        getInput();
        movePlayer();
    }
    
    private void getInput() {
        if (Input.GetKey(KeyCode.W) || Input.GetKey(KeyCode.A) || Input.GetKey(KeyCode.S) || Input.GetKey(KeyCode.D)) {
            inputVector = new Vector3(Input.GetAxisRaw("Vertical"), 0, Input.GetAxisRaw("Horizontal"));
            inputVector.Normalize();
            inputVector = transform.TransformDirection(inputVector);
        } else {
            inputVector = Vector3.Lerp(inputVector, Vector3.zero, momentumDamping * Time.deltaTime);
        }

        movementVector = (inputVector * speed) + (Vector3.up * gravity);
    }
    
    private void movePlayer() {
        character.Move(movementVector * Time.deltaTime);
    }
}
