package base;

public class FindFirstCommonNode {
	/*
	 * �����Ƚ�����
	 * ʹ��˫ָ���˼��
	 * ����ָ��һ���ܣ��Ƚ���������������֮ǰ�Ľڵ�������ȵ�
	 * ��ô��һ�α���������һ��������ֱ�ӷ����Ǹ������Ľڵ�
	 * ��һ������������������������ڵ�֮ǰ�Ľڵ���Ŀ�ǲ���ȵ�
	 * ��ô���������ڵ�abһ���ߣ����������������������������һ���ڵ�a���ߵ�ĩβnull
	 * Ȼ����������ڵ�aȥ����һ���ڵ�b���������ͷ������������һ���ߣ�֮��b�ֱ�Ȼ�ȵ�null
	 * ����bȥ��aһ��ʼ���ڵ����������ͷ������������һ���ߡ�
	 * ����������Ȼ��commonNode������
	 * ���������֪��ԭ���ˣ��������ν���֮���൱���������ߵ���һ��·������a��������һ�����������b�����������������һ
	 * ab�����ξ���commonNode�����ڵڶ��ξ���ʱ�����Ǿͻ�������
	 */
	public class Solution {	
		public class ListNode {
		    int val;
		    ListNode next = null;

		    ListNode(int val) {
		        this.val = val;
		    }
		}
	    private ListNode FindFirstCommonNode(ListNode p1, ListNode p2, ListNode pHead1, ListNode pHead2){
	            p1 = pHead2;
	            while(p1 != null && p2 != null){
	                p1=p1.next;
	                p2=p2.next;
	            }
	            
	            p2 = pHead1;
	        
	            while(p1!=p2){
	                p1=p1.next;
	                p2=p2.next;
	            }
	            
	            return p1;
	    }
	    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
	        ListNode p1 = pHead1;
	        ListNode p2 = pHead2;
	        
	        while(p1!=null && p2!=null){
	        	if(p1==p2){
	                return p1;
	            }
	            p1 = p1.next;
	            p2 = p2.next;
	        }
	        
	        if(p1==null){
	            return FindFirstCommonNode(p1,p2,pHead1,pHead2);
	        }else{
	            return FindFirstCommonNode(p2,p1,pHead2,pHead1);
	        }
	        
	        
	    }
	}
}
