public class List<ContentType> {
  
    private class Node {
        
      private ContentType content = null;
      private Node nextNode = null;

      public Node(ContentType pContent) {
        content = pContent;
      }

      public void setNext(Node pNext) {
        nextNode = pNext;
      }

      public Node getNext() {
        return nextNode;
      }

      public ContentType getContent() {
        return content;
      }

    }

    private Node first;
    private Node last;
    private Node current;

    public List() {
      first = null;
      last = null;
      current = null;
    }

    public boolean isEmpty() {
      return first == null;
    }

    public boolean hasAccess() {
      return current != null;
    }

    public void next() {
      if(!isEmpty() && hasAccess() && current != last) {
        current = current.getNext();
      } else {
        current = null;
      }
    }

    public void toFirst() {
      if(!isEmpty()) {
        current = first;
      }
    }

    public void toLast() {
      if(!isEmpty()) {
        current = last;
      }
    }

    public ContentType getContent() {
      if(hasAccess()) {
        return current.getContent();
      }
      return null;
    }

    public void setContent(ContentType pContent) {
      if(hasAccess() && pContent != null) {
        current = new Node(pContent);
      }
    }

    public void append(ContentType pContent) {
      if(pContent != null) {
        Node node = new Node(pContent);
        if(isEmpty()) {
          first = node;
          last = node;
        } else {
          last.setNext(node);
          last = node;
        }
      }
    }

    public void insert(ContentType pContent) {
      if(pContent != null) {
        Node node = new Node(pContent);
        if(isEmpty()) {
          first = node;
          last = node;
        } else if(hasAccess()) {
          if(current == first) {
            first = node;
            first.setNext(current);
          } else {
            Node stop = current;
            toFirst();
            while(current.getNext() != stop) {
              next();
            }
            current.setNext(node);
            current.getNext().setNext(stop);
            current = stop;
          }
        }
      }
    }

    public void concat(List<ContentType> pList) {
      if(pList != null && !pList.isEmpty()) { // && Listen muessen ungleich sein
        pList.toFirst();
        while(!pList.isEmpty()) {
          append(pList.getContent());
          pList.remove();
        }
      }
    }

    public void remove() {
      if(hasAccess() && !isEmpty()) {
        if(current == first) {
          if(first.getNext() != null) {
            first = first.getNext();
            current = first;
          } else {
            first = null;
            last = null;
            current = null;
          }
        } else {
          Node stop = current;
          toFirst();
          while(current.getNext() != stop) {
            System.out.println(current.getContent());
            next();
          }
          if(stop.getNext() != null) {
            current.setNext(stop.getNext());
            current = stop.getNext();
          } else {
            current.setNext(null);
            current = null;
          }
        }
      }
    }

  }