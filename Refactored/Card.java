public record Card(String suit, String rank) {
    // Public methods available: getSuit(), getRank()
    public String convertToString() {
        return suit + rank;
    }
}
