package datebase_jon;

public class Review {
	public Integer review_id;
	public Integer user_id;
	public Integer product_id;
	public String reviewer_name;
	public String review_rating;
	public String review_content;
	
	public Review()
	{
		
	}
	
	public Review(Integer review_id, Integer user_id, Integer product_id, String reviewerName, String review_rating, String review_content)
	{
		this.review_id = review_id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.reviewer_name = reviewerName;
		this.review_rating = review_rating;
		this.review_content = review_content;
	}
}
