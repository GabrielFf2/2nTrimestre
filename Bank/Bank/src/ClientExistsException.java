public class ClientExistsException extends Exception {
    private Client client;

    public ClientExistsException(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Client '" + client.fullName() + "' already exists.";
    }

}