@RestController
@RequestMapping("/api/customers")
public class CustomerProfileController {

    private final CustomerProfileService customerProfileService;

    public CustomerProfileController(CustomerProfileService customerProfileService) {
        this.customerProfileService = customerProfileService;
    }

    @PostMapping
    public CustomerProfile createCustomer(@RequestBody CustomerProfile customer) {
        customer.setId(null); // ✅ ONLY this line is needed
        return customerProfileService.createCustomer(customer);
    }

    @GetMapping("/{id}")
    public CustomerProfile getCustomer(@PathVariable Long id) {
        return customerProfileService.getCustomerById(id);
    }

    @GetMapping
    public List<CustomerProfile> getAllCustomers() {
        return customerProfileService.getAllCustomers();
    }
}
