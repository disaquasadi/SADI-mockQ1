Just change them all
dont let class clash.


WAY TO RUN MAIN.
List<Post> posts = orderService.findPosts("haha");

List<Post> posts1 = orderService.findPostsByAuthor(john);

List<Comment> comments = orderService.findComments("aloalo");


for (Post post : posts) {
    System.out.println("Post content: " + post.getContent());
}

System.out.println("Posts by jack: " + jack.getName());

for (Post post : posts1) {
    System.out.println("Post content: " + post.getContent());
}

for (Comment commenttest : comments) {
    System.out.println("Comments found: " + commenttest.getId());
    }
