0. Change POM dependecy


1. Just change them all: change class name, attribute, everything according to exam dont let class clash.

2. Change Database Credential in AppConfig

3. Make sure to cite bean

4. Make sure not missing any annotatitions


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
